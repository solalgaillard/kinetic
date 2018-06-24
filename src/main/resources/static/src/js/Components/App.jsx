import React from 'react'
import {HashRouter, Route } from 'react-router-dom'
import Login from './Login/Login.jsx'
import { ChangeImage, Home } from '../redux/Containers.jsx'
import styles from './app.sass'



const App = () =>
    <main className={styles.App}>
        <ChangeImage />
        <HashRouter>
            <div>
                <Route exact path="/" component={Login} />
                <Route path="/home" component={Home} />

            </div>
        </HashRouter>
    </main>

export default App
