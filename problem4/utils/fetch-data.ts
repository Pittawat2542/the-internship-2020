import axios from 'axios';
import cheerio from 'cheerio';

const fetchData = async () => {
    const response = await axios.get('https://theinternship.io');
    const $ = cheerio.load(response.data);

    const listOfCompanies = $(
        '#__layout>div>div>section:nth-child(5)>.container>div'
    ).toArray()[1];

    const parsedListOfCompanies: {
        logoURL: string;
        description: string;
        length: number;
    }[] = [];

    listOfCompanies.children.forEach(company => {
        parsedListOfCompanies.push({
            logoURL: $(company).find('a > img')
                .attr('src')!,
            description: $(company)
                .text()
                .trim(),
            length: $(company).text().length
        });
    });
    
    parsedListOfCompanies.sort((a, b) => a.length - b.length);
    return parsedListOfCompanies;
};

export default fetchData;
