from pydantic import BaseModel

from typing import Optional


class Links(BaseModel):
    self_link: str
    next: Optional[str]
    prev: Optional[str]
    parent: Optional[str]
    children: Optional[str]
    first: Optional[str]
    last: Optional[str]
    search: Optional[str]
