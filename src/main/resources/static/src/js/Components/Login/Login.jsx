import React from 'react'
import styles from './login.sass'

var webAuth = new auth0.WebAuth({
    domain:       'kineticexpress.auth0.com',
    clientID:     '7bug4gdhtEeo77gXDz0dBl1KBjVr5I1O',
})

function socialOAuth2(webAuth, serviceProvider) {
    webAuth.popup.authorize({
        connection: serviceProvider,
        display:'popup',
        responseType: 'token',
        redirectUri: 'https://localhost/social-login-redirect.html'
    }, function(err, authResult) {
        //do something
    })
}

/*FOR LOGIN NOT GOOD PLACE*/
window.addEventListener("message", receiveMessage, false)

function receiveMessage(event)
{
    if (event.origin !== "http://localhost/social-login-redirect.html")
        return

    console.log(event.data)
}/*

webAuth.parseHash(window.location.hash, function(err, data) {*/


const Login = ({googleLogin = () => socialOAuth2(webAuth, 'google-oauth2'),
               facebookLogin = () => socialOAuth2(webAuth, 'facebook')}) =>
    <form className={styles.login}>
        <input type="text" name="email" value="email" />
        <input type="text" name="password" value="password" />
        <button type="button">forgot your password?</button>
        <div>
            <input type="submit" value="log in" />
            <p>or</p>
            <button onClick={googleLogin} type="button">login in with Google</button>
            <button onClick={facebookLogin}  type="button">login in with Facebook</button>
        </div>
        <button type="button">create account</button>
    </form>


export default Login
