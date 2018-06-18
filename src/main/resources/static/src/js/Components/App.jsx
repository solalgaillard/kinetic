import React from 'react'
import Login from './login/Login.jsx'
import { ChangeImage } from '../redux/Containers.jsx'
import styles from './app.sass'

const App = () =>
    <main className={styles.App}>
        <ChangeImage />
        <Login />
    </main>

export default App
