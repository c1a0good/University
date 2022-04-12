from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

from dependencie import get_db_settings

settings = get_db_settings()

# SQLALCHEMY_DATABASE_URL = f"postgresql://{settings.username}:{settings.password}@{settings.host}:{settings.port}/{settings.database}"
SQLALCHEMY_DATABASE_URL = f"postgresql://{settings.username}:{settings.password}@db/{settings.database}"
engine = create_engine(SQLALCHEMY_DATABASE_URL)
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

Model = declarative_base()