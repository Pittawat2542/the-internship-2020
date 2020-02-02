import express from 'express';
import fetchData from './utils/fetch-data';

(async () => {
    const parsedListOfCompanies = await fetchData();
    parsedListOfCompanies.map(company => console.log(company.logoURL));
})();

const app = express();

app.get('/', (_, res) => res.send("It works!"))

app.get('/companies', async (_, res) => {
    const parsedListOfCompanies = await fetchData();
    res.json({
        companies: parsedListOfCompanies.map(company => ({logo: `https://theinternship.io/${company.logoURL}`}))
    });
});

app.listen(3000);
