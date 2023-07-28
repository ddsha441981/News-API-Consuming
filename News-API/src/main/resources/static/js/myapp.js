document.addEventListener("DOMContentLoaded", () => {
	// Function to fetch data from the backend
	// Call the fetchData function when the page is loaded
	categoryNews();
	popularityNews();
	countryNews();
	headlinesNews();
	sourcesNews();
	sourcesCountryNews();
});

function categoryNews() {
	fetch('/category/sports')
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Error fetching data:', error);
		});
}

function popularityNews() {
	fetch('/popularity')
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Error fetching data:', error);
		});
}

function countryNews() {
	fetch('/country/us')
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Error fetching data:', error);
		});
}

function headlinesNews() {
	fetch('/headline/narendramodi')
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Error fetching data:', error);
		});
}

function sourcesNews() {
	fetch('/sources')
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Error fetching data:', error);
		});
}

function sourcesCountryNews() {
	fetch('/sources/in')
		.then(response => response.json())
		.then(data => {
			console.log(data);
		})
		.catch(error => {
			console.error('Error fetching data:', error);
		});
}




