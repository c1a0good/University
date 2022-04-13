from functools import lru_cache
from sqlalchemy.orm import Session
import config
import database
from fastapi import Depends,HTTPException,Body
from fastapi.security import OAuth2PasswordBearer
from auth import Auth
import os
import httpx
from typing import List
# Вызывается по время внедрения зависимости
def get_db() -> Session:
    db = database.SessionLocal()
    try:
        yield db
    finally:
        db.close()

# Возврат существующего экземпляра DBSettings вместо создания нового
@lru_cache
def get_db_settings() -> config.DBSettings:
    return config.DBSettings()



oauth2_scheme = OAuth2PasswordBearer(tokenUrl="/login/")


async def get_current_user(token: str = Depends(oauth2_scheme),auth:Auth=Depends()):
    username = auth.decode_token(token)
    if not username:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED,
            detail="Invalid authentication credentials",
            headers={"WWW-Authenticate": "Bearer"},
        )
    return username



CAST_SERVICE_HOST_URL = 'http://localhost:8081/students'
url = os.environ.get('CAST_SERVICE_HOST_URL') or CAST_SERVICE_HOST_URL







def student_list():
    try:
        r = httpx.get(f'{url}/')
    except:
        raise HTTPException(staus_code=505)

    return r.json()




def student_id(id:int):
    try:
      r = httpx.get(f'{url}/{id}')
      print(r.json())
    except r.extensions:
        raise r.extensions

    return r.json()


def student_id_post(id:int=Body(...)):

    try:
      r = httpx.get(f'{url}/{id}')
    except r.extensions:
        raise r.extensions

    return r.json()