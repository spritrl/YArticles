# Creer une base de données

# Article (id, title, slug, content, author, date)
# Comment (comment_id, title, content, article_id)
import sqlite3

connexion = sqlite3.connect('api_db.db')

cursor = connexion.cursor()

cursor.execute("PRAGMA foreign_key = ON")

cursor.execute(""" CREATE TABLE IF NOT EXISTS article (
               id INTEGER  PRIMARY KEY AUTOINCREMENT,
               title VARCHAR(256),
               slug VARCHAR(256),
               content TEXT,
               author VARCHAR(64),
               date DATETIME
               )""")

cursor.execute(""" CREATE TABLE IF NOT EXISTS comment (
    id INTEGER PRIMARY KEY  AUTOINCREMENT,
    title VARCHAR(256),
    content TEXT,
    article_id INTEGER,
    FOREIGN KEY (article_id)
        REFERENCES article(id)
) """)

connexion.commit()

connexion.close()