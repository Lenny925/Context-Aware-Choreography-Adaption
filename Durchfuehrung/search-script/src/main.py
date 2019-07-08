import gin

from analysis.count_duplicates import count_similar_results
from crawler.springer import SpringerLink
from crawler.ieee.ieee import IEEEXplore
from crawler.google import GoogleScholar
from input_output.csv import CSV
from input_output.queries import Queries
from input_output.super_csv import SuperCsv


def execute_queries():
    gin.parse_config_file('config.gin', True)

    crawler = IEEEXplore()
    queries = Queries().get_queries()

    crawler_name = type(crawler).__name__
    csv = CSV(crawler_name)

    for query in queries:
        print(f'Querying {crawler_name} for {query}...')

        results = crawler.crawl(query)
        csv.write(results, query[:-1] + '_' + crawler_name + '.csv')


def count_duplicates():
    print('Starting to count similar results')

    results = SuperCsv().get_super_csv()
    print('Done reading files')
    csv2 = CSV()
    csv2.write(results, 'resultsT.csv')
    similarities = count_similar_results(results)
    csv = CSV()
    csv.write(similarities, 'resultsT.csv')
    print('Finished counting similar results')

	
def get_all_in_one():
    print('Starting to crawl results')

    results = SuperCsv().get_super_csv()
    print('Done reading files')
    csv2 = CSV()
    csv2.write(results, 'resultsInOne.csv')
	
    print('Finished crawling all results')

if __name__ == '__main__':
    execute_queries()
