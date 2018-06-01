import React from 'react'
import styles from './general.sass'
import Login from './Components/Login/Login.jsx';
import BackgroundSlideshow from './Components/BackgroundSlideshow/BackgroundSlideshow.jsx';

const App = () =>
    <main className={styles.App}>
        <BackgroundSlideshow />
        <Login />
    </main>

export default App
