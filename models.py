from sqlalchemy import Boolean, Column, ForeignKey, Integer, String, DateTime
from sqlalchemy.orm import relationship
from database import Model
from datetime import datetime

class Student(Model):
    __tablename__ = "students"

    id = Column(Integer, primary_key=True, index=True)
    first_name=Column(String)
    second_name=Column(String)



class User(Model):
    __tablename__ = "users"

    id = Column(Integer, primary_key=True, index=True)
    username=Column(String,unique=True,index=True)
    hashed_password = Column(String)
    is_active = Column(Boolean, default=True)



