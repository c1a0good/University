from typing import List

from fastapi import FastAPI, status, Depends, HTTPException
from fastapi.middleware.cors import CORSMiddleware

from database import engine



from models import Model
from router import student_route, resident_route, auth_route

Model.metadata.create_all(bind=engine)
app = FastAPI()
app.include_router(student_route.router)
app.include_router(resident_route.router)
app.include_router(auth_route.router)

origins = [
    "http://localhost.tiangolo.com",
    "https://localhost.tiangolo.com",
    "http://localhost",
    "http://localhost:8000",
    "http://localhost:8000/students/"
    "http://localhost:8000/residents/"
]

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)
@app.get("/")
async def root():
    return {"message": "Dormitory"}





