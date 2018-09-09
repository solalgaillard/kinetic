import React, {Component} from 'react'
import cx from "classnames";
import styles from './inbox-counter.sass'


const InboxCounter = ({styleName}) =>
    <div className={cx(styles['inbox-counter'], styleName)} >
        <img src="src/img/common/inbox-icon.png" />
        <h1>messages (32)</h1>
    </div>

export default InboxCounter