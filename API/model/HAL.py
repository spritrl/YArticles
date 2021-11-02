from typing import Optional

from pydantic import BaseModel


class Links(BaseModel):
    self: str
    search: Optional[str]
    parent: Optional[str]
    children: Optional[list]
    next: Optional[str]
    prev: Optional[str]
    last: Optional[str]