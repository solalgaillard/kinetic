import React from 'react'
import styles from './login.sass'

var webAuth = new auth0.WebAuth({
    domain:       'kineticexpress.auth0.com',
    clientID:     '7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O',
    postMessageDataType: 'custom-type'
});



function googleAuth() {
    webAuth.popup.authorize({
        connection: 'google-oauth2',
        responseType: 'token',
        redirectUri: 'https://localhost/social-login-redirect.html'
    }, function(err, authResult) {
           //do something
         });
}

function facebookAuth() {
    webAuth.popup.authorize({
        connection: 'facebook',
        display:'popup',
        responseType: 'token',
        redirectUri: 'https://localhost/social-login-redirect.html'
    }, function(err, authResult) {
       //do something
     });
}



const Login = (props) =>
     <form className={styles.login}>
        <input type="text" name="email" value="email" />
        <input type="text" name="password" value="password" />
        <button type="button">forgot your password?</button>
        <div>
            <input type="submit" value="log in" />
            <p>or</p>
            <button type="button">login in with Google</button>
            <button type="button">login in with Facebook</button>
        </div>
        <button type="button">create account</button>
    </form>


export default Login
