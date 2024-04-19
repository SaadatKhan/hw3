window.onload = function() {
    fetchSurveys(); // Initial fetch of surveys
};

function fetchSurveys() {
    fetch('http://34.197.230.208:30007/surveys')
        .then(response => response.json())
        .then(data => {
            const tableBody = document.getElementById('surveysTable').getElementsByTagName('tbody')[0];
            tableBody.innerHTML = ""; // Clear the table before inserting new rows
            data.forEach(survey => {
                let row = tableBody.insertRow();
                row.innerHTML = `
                    <td>${survey.id}</td>
                    <td>${survey.firstName}</td>
                    <td>${survey.lastName}</td>
                    <td>${survey.streetAddress}</td>
                    <td>${survey.city}</td>
                    <td>${survey.state}</td>
                    <td>${survey.zip}</td>
                    <td>${survey.telephone}</td>
                    <td>${survey.email}</td>
                    <td>${survey.surveyDate}</td>
                    <td>${survey.campusPreferences}</td>
                    <td>${survey.interestSource}</td>
                    <td>${survey.likelihoodOfRecommending}</td>
                    <td>${survey.raffleNumbers}</td>
                    <td>${survey.additionalComments}</td>
                    <td>
                        <button onclick="editSurvey(${survey.id})" class="button-edit">Edit</button>
                        <button onclick="deleteSurvey(${survey.id})" class="button-delete">Delete</button>
                    </td>
                `;
            });
        }).catch(error => console.error('Error fetching surveys:', error));
}

function editSurvey(id) {
    const editForm = document.getElementById('editSurveyForm');
    editForm.setAttribute('data-survey-id', id); // Setting the survey ID on the form for later use
    document.getElementById('editModal').style.display = 'block';

    fetch(`http://34.197.230.208:30007/surveys/${id}`)
        .then(response => response.json())
        .then(data => {
            document.getElementById('editFirstName').value = data.firstName;
            document.getElementById('editLastName').value = data.lastName;
            document.getElementById('editStreetAddress').value = data.streetAddress;
            document.getElementById('editCity').value = data.city;
            document.getElementById('editState').value = data.state;
            document.getElementById('editZip').value = data.zip;
            document.getElementById('editTelephone').value = data.telephone;
            document.getElementById('editEmail').value = data.email;
            document.getElementById('editSurveyDate').value = data.surveyDate;
            document.getElementById('editCampusPreferences').value = data.campusPreferences;
            document.getElementById('editInterestSource').value = data.interestSource;
            document.getElementById('editLikelihoodOfRecommending').value = data.likelihoodOfRecommending;
            document.getElementById('editRaffleNumbers').value = data.raffleNumbers;
            document.getElementById('editAdditionalComments').value = data.additionalComments;
        })
        .catch(error => console.error('Error loading survey data:', error));
}

function closeModal() {
    document.getElementById('editModal').style.display = 'none';
}

document.getElementById('editSurveyForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const surveyId = this.getAttribute('data-survey-id');
    updateSurvey(surveyId);
});

function updateSurvey(surveyId) {
    const formData = {
        firstName: document.getElementById('editFirstName').value,
        lastName: document.getElementById('editLastName').value,
        streetAddress: document.getElementById('editStreetAddress').value,
        city: document.getElementById('editCity').value,
        state: document.getElementById('editState').value,
        zip: document.getElementById('editZip').value,
        telephone: document.getElementById('editTelephone').value,
        email: document.getElementById('editEmail').value,
        surveyDate: document.getElementById('editSurveyDate').value,
        campusPreferences: document.getElementById('editCampusPreferences').value,
        interestSource: document.getElementById('editInterestSource').value,
        likelihoodOfRecommending: document.getElementById('editLikelihoodOfRecommending').value,
        raffleNumbers: document.getElementById('editRaffleNumbers').value,
        additionalComments: document.getElementById('editAdditionalComments').value,
    };

    fetch(`http://34.197.230.208:30007/surveys/${surveyId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (response.ok) {
            console.log('Update successful');
            closeModal();
            fetchSurveys(); // Refresh the list to show updated data
        } else {
            response.json().then(data => console.error('Failed to update survey:', data));
        }
    })
    .catch(error => console.error('Error updating survey:', error));
}

function deleteSurvey(id) {
    if (confirm("Are you sure you want to delete this survey?")) {
        fetch(`http://34.197.230.208:30007/surveys/${id}`, {
            method: 'DELETE'
        })
        .then(response => {
            if (response.ok) {
                console.log('Survey deleted successfully');
                fetchSurveys(); // Refresh the list after deletion
            }
        })
        .catch(error => console.error('Error deleting survey:', error));
    }
}
