from datetime import datetime
from typing import Optional

from pydantic import BaseModel


class OutArticle(BaseModel):
    article_id: int
    title: Optional[str]
    slug: Optional[str]
    content: Optional[str]
    author: Optional[str]
    date: Optional[datetime]


class InArticle(BaseModel):
    title: str
    slug: str
    content: str
    author: str
    date: datetime
