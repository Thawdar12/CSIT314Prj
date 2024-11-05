// form-handler.js

// Select the form element
const form = document.getElementById('loginForm');

// Add an event listener for the 'submit' event
form.addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent the form from submitting

    // Get form values and convert to a JSON object
    const formData = new FormData(form);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    // Send the JSON data using the fetch API
    fetch('/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(result => {
        console.log('Success:', result);
        alert('Form submitted successfully!');
    })
    .catch(error => {
        console.error('Error:', error);
        alert('There was an error submitting the form.');
    });
});
