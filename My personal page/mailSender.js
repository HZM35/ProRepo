const contactForm = document.getElementById("contact-form");

contactForm.addEventListener("submit", (event) => {
  event.preventDefault();

  const sendMail = async () => {
    var params = {
      name: document.getElementById("name").value,
      subject: document.getElementById("subject").value,
      email: document.getElementById("email").value,
      message: document.getElementById("message").value,
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

    document.getElementById("name").value = "";
    document.getElementById("subject").value = "";
    document.getElementById("email").value = "";
    document.getElementById("message").value = "";
    console.log("Your message has been sent successfully");
  };

  sendMail();
});
