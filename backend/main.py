from fastapi import FastAPI, Depends, HTTPException
from fastapi.security import HTTPBearer, HTTPAuthorizationCredentials
import firebase_admin
from firebase_admin import auth, credentials
from supabase import create_client
import os, json
from dotenv import load_dotenv

# Initialize Firebase Admin SDK
firebase_creds = os.getenv("FIREBASE_CREDENTIALS")

if not firebase_admin._apps:  # prevents re-init
    cred = credentials.Certificate(json.loads(firebase_creds))
    firebase_admin.initialize_app(cred)

load_dotenv()  # load .env file

SUPABASE_URL = os.getenv("SUPABASE_URL")
SUPABASE_KEY = os.getenv("SUPABASE_KEY")

supabase = create_client(SUPABASE_URL, SUPABASE_KEY)

app = FastAPI()
security = HTTPBearer()

# Dependency to verify token
def verify_token(credentials: HTTPAuthorizationCredentials = Depends(security)):
    token = credentials.credentials
    try:
        decoded_token = auth.verify_id_token(token)
        return decoded_token
    except Exception as e:
        raise HTTPException(status_code=401, detail="Invalid token")
    
def save_user(uid: str, email: str):
    try:
        response = supabase.table("users").insert({"uid": uid, "email": email}).execute()
        return response.data
    except Exception as e:
        print("Error saving user:", e)
        return None


def get_user_by_uid(uid: str):
    response = supabase.table("users").select("*").eq("uid", uid).execute()
    if response.data:
        return response.data[0]
    return None

@app.post("/auth/signup")
def signup(user_data=Depends(verify_token)):
    uid = user_data["uid"]
    email = user_data.get("email")

    existing_user = get_user_by_uid(uid)
    if existing_user:
        return {
            "message": "User already exists",
            "user": existing_user
        }

    new_user = save_user(uid, email)
    return {
        "message": "User created successfully",
        "user": new_user
    }

@app.post("/auth/signin")
def signin(user_data=Depends(verify_token)):
    uid = user_data["uid"]
    email = user_data.get("email")

    existing_user = get_user_by_uid(uid)
    if not existing_user:
        # Optional: auto-create if somehow missing in Supabase
        save_user(uid, email)
        return {
            "message": "User signed in, new record created",
            "user": {"uid": uid, "email": email}
        }

    return {
        "message": "User signed in successfully",
        "user": existing_user
    }


@app.get("/users/me")
def get_me(user_data = Depends(verify_token)):
    return {"uid": user_data["uid"], "email": user_data.get("email")}


@app.get("/")
def root():
    return {"message": "Backend is running 🚀"}
