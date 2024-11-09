// JavaScript to handle form submission
document.getElementById('contactForm').addEventListener('submit', function(event) {
    event.preventDefault();
    
    const fullName = document.getElementById('fullName').value;
    const email = document.getElementById('email').value;
    const mobile = document.getElementById('mobile').value;
    const city = document.getElementById('city').value;
    
    if(fullName && email && mobile && city) {
        alert('Thank you, ' + fullName + '! Your details have been submitted.');
    } else {
        alert('Please fill in all the fields correctly.');
    }
});
