import React, { PropTypes, Component } from 'react'
import styles from './home.sass'
import cx from 'classnames'
import { Logo } from '../../common/logo/Logo.jsx'
import { Profile } from '../common/1-profile/Profile.jsx'
import { ListPanel } from './1-listPanel/ListPanel.jsx'
import SearchAndTitleBar from '../common/2-Search&TitleBar/searchAndTitleBar.jsx'
import { Feed } from '../common/3-feed/Feed.jsx'
import { OtherUsersPanel } from './3-otherUsersPanel/OtherUsersPanel.jsx'
import InboxCounter from '../common/4-inboxCounter/InboxCounter.jsx'



const Home = () =>
    <section className={styles.home} >
        <Logo styleName={styles.logo} />
        <Profile styleName={styles.profile} />
        <ListPanel styleName={styles['list-panel']} />
        <SearchAndTitleBar styleName={styles['search-and-title-bar']} />
        <Feed styleName={styles.feed} />
        <OtherUsersPanel styleName={styles['other-users-panel']} />
        <InboxCounter styleName={styles['inbox-counter']} />
    </section>


export default Home