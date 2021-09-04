import requests
import os
import pdfkit
from requests_html import HTMLSession
from bs4 import BeautifulSoup

#Page 0-30 by 09/03/2021
PREFIX = "https://open.kattis.com/problems?page="
POSTFIX = "&order=problem_difficulty&dir=asc"
SAMPLE_POSTFIX = "/file/statement/samples.zip"

path_wkhtmltopdf = r'C:\DevApps\wkhtmltox\bin\wkhtmltopdf.exe'
config = pdfkit.configuration(wkhtmltopdf=path_wkhtmltopdf)

# initialize an HTTP session
session = HTMLSession()


# Download zip file
def download_url(url, save_path):
    r = requests.get(url)

    if r.status_code != 200:
        print("Failed to download samples with status code %s." % r.status_code)
    else:
        with open(save_path, 'wb') as out_file:
            out_file.write(r.content)

# Get test input ids from uDebug page like "https://www.udebug.com/UVa/10032"
def get_problems(url):
    # GET request
    response = session.get(url)
    # for javascript driven website
    # res.html.render()
    soup_obj = BeautifulSoup(response.html.html, "html.parser")
    problems = soup_obj.find_all("td", class_="name_column")
    id_set = set()
    for problem in problems:
        links = problem.find_all("a")
        for link in links:
            id_set.add(link["href"])
    return list(id_set)


# Crawl test data from uDebug and write to local files for UVA problems
def crawl_problem(title):
    problem_url = "https://open.kattis.com" + title
    sample_url = problem_url + SAMPLE_POSTFIX
    index = problem_url.rindex("/")
    real_title = problem_url[index+1:]
    local_folder = "./Kattis"
    # If folder doesn't exist, then create it.
    if not os.path.isdir(local_folder):
        os.makedirs(local_folder)

    pdf_file = local_folder + "/" + real_title + ".pdf"
    try:
        pdfkit.from_url(problem_url, pdf_file, configuration=config)
    except:
        print("Warning")
    zip_file = local_folder + "/" + real_title + ".zip"
    download_url(sample_url, zip_file)


#crawl_problem("/problems/ligatures")
for page in range(0, 31):
    url = PREFIX + str(page) + POSTFIX
    print("working on page " + url)
    pdf = "Kattis-page-" + str(page) + ".pdf"
    try:
        pdfkit.from_url(url, pdf, configuration=config)
    except:
        print("Warning")
    page_problems = get_problems(url)
    for title in page_problems:
        print("working on " + title)
        crawl_problem(title)
