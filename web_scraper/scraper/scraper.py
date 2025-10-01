import requests
from bs4 import BeautifulSoup

def scrape_website(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, "html.parser")
    quotes = []
    for quote in soup.find_all("div", class_="quote"):
        text = quote.find("span", class_="text").get_text()
        author = quote.find("small", class_="author").get_text()
        quotes.append({"text": text, "author": author})
    return quotes
