 function sendMail(){
    var params = {
        name:document.getElementById("name").value ,
        subject:document.getElementById("subject").value ,
        email:document.getElementById("email").value ,
        message:document.getElementById("message").value 
    };
    
    const serviceID = "service_bp6u6tc";
    const templateID = "template_44z4jkg";
    
    emailjs
    .send(serviceID,templateID, params)
    .then(
            (res) => {
            document.getElementById("name").value= "";
            document.getElementById("subject").value= "";
            document.getElementById("email").value= "";
            document.getElementById("message").value= "";
            console.log(res);
            alert("Your message has been sent successfully");
        })
    .catch((err)=> console.log(err));
}