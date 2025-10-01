# Web Scraper

A simple web scraper to extract quotes and authors from [Quotes to Scrape](https://quotes.toscrape.com/) and save the data in CSV or JSON format.  

## Features
- Scrape quotes and authors from a website.
- Save data to CSV or JSON.
- Easy to extend to other websites.

## Folder Structure


web-scraper/
│
├── README.md                 # Instructions for usage
├── requirements.txt          # List of dependencies (e.g., requests, BeautifulSoup)
├── .gitignore                # To ignore unnecessary files (e.g., __pycache__)
│
├── scraper/                  # Main Python package
│   ├── __init__.py           # Makes 'scraper' a Python package
│   ├── main.py               # Entry point for running the scraper
│   ├── scraper.py            # Contains the scraping logic/functions
│   ├── utils.py              # Utility functions (e.g., save to CSV/JSON)
│
└── data/                     # Folder to store scraped data
    ├── output.csv
    └── output.json
