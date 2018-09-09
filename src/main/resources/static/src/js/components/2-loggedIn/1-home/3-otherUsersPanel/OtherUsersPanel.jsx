import React, {Component} from 'react'
import cx from "classnames";
import styles from './other-users-panel.sass'


const OtherUsersPanel = ({styleName}) =>
    <h3 className={cx(styles['other-users-panel'], styleName)} >Other Users Panel</h3>

export default OtherUsersPanel