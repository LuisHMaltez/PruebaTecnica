/*import React, { useState } from 'react'
import  { ProductoCatalogo } from './ProductoCatalogo'

function Login() {

    const [miLogin, setMiLogin] = useState("false");
    const [usu, setUsu] = useState("");
    const [pass, setPass] = useState("");

    function iniciarSesion(e){
        e.preventDefault();
        var txtusu = document.getElementById("txtusu").value;
        var txtpass = document.getElementById("txtpass").value;
        if(txtusu.length === 0 || txtpass.length === 0) {
            alert("Complete los datos faltantes")
        } else {
            if(usu === "admin" && pass === "123") {
                setMiLogin("True")
                document.getElementById("form_login").style.display = "none";
            } else {
                setMiLogin("false");
                alert("Error de usuario y/o contraseña")
                document.getElementById("txtusu").value = "";
                document.getElementById("txtpass").value = "";
                document.getElementById("txtusu").focus();
            }
        }
    }

  return (
    
    
    <div className="container" style={{background:"lightgray", marginTop:20, padding:20, alignContent:'center'}}>
        
    <form id="form_login">
        <div>
            <h1 style={{color:"blue", textalign:"center"}}>LOGIN</h1>
            <label htmlFor="txtusu"><strong>Username</strong></label>
            <input type="text" id="txtusu" style={{textAlign:"center"}} className="form-control" onChange={(e)=>setUsu(e.target.value)}  required/>
        </div>
        <div>
            <label htmlFor="txtpas"><strong>Password</strong></label>
            <input type="password" id="txtpass" style={{textAlign:"center"}} className="form-control" onChange={(e)=>setPass(e.target.value)} required/>
        </div><br/>
        <input type="submit" className="btn btn-primary" value="Login" onClick={iniciarSesion}/>
    </form>

    {miLogin === "true" && <ProductoCatalogo/> }

</div>

  )
}

export default Login*/