import React, { PropTypes, Component } from 'react'
import styles from './home.sass'
import cx from 'classnames'
import { Profile } from '../common/1-profile/Profile.jsx'
import { ListPanel } from './1-listPanel/ListPanel.jsx'
import SearchAndTitleBar from '../common/2-Search&TitleBar/SearchAndTitleBar.jsx'
import { Feed } from '../common/3-feed/Feed.jsx'
import OtherUsersPanel from './3-otherUsersPanel/OtherUsersPanel.jsx'



const Home = () =>
    <section>
        <div className={styles.logo}><img src='src/img/common/logo.png' /><h1>Qinetic</h1></div>
        <Profile className={styles.profile} />
        <ListPanel />
        <SearchAndTitleBar />
        <Feed />
        <OtherUsersPanel />
    </section>


export default Home