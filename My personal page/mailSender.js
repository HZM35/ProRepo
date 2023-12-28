const contactForm = document.getElementById("contact-form");

contactForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const sendMail = async () => {
    const nameInput = document.getElementById("name");
    const subjectInput = document.getElementById("subject");
    const emailInput = document.getElementById("email");
    const messageInput = document.getElementById("message");

    var params = {
      name: nameInput.value,
      subject: subjectInput.value,
      email: emailInput.value,
      message: messageInput.value,
    };

    const serviceID = "service_bp6u6tc";
    const templateID = "template_44z4jkg";

    // Prüfen, ob alle Formularfelder ausgefüllt sind.
    if (params.name === "" || params.subject === "" || params.email === "" || params.message === "") {
      alert("Bitte füllen Sie alle Felder aus.");
      return;
    }
    if (!confirm("Are you sure you want to send this message?")) {
      return;
    }
    await emailjs.send(serviceID, templateID, params);

    nameInput.value = "";
    subjectInput.value = "";
    emailInput.value = "";
    messageInput.value = "";
    alert("Your message has been sent successfully");
  };

  sendMail();
});