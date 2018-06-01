import React from 'react'
import styles from './login.sass'

const Login = (props) =>
     <form className={styles.login}>
        <input type="text" name="email" value="email" />
        <input type="text" name="password" value="password" />
        <button type="button">forgot your password?</button>
        <div>
            <input type="submit" value="log in" />
            <p>or</p>
            <button type="button">login in with</button>
            <button type="button">login in with</button>
        </div>
        <button type="button">create account</button>
    </form>


export default Login
