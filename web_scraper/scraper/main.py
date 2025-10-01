from scraper.scraper import scrape_website
from scraper.utils import save_to_csv, save_to_json

if __name__ == "__main__":
    url = "https://quotes.toscrape.com/"
    data = scrape_website(url)
    save_to_csv(data, "data/output.csv")
    save_to_json(data, "data/output.json")
    print("Scraping completed. Data saved to output.csv and output.json")
