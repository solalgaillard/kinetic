import { connect } from "react-redux"
import React, {Component} from 'react'
import cx from "classnames"
import styles from './logo.sass'


export const Logo = ({ styleName }) =>
    <div className={cx(styles.logo, styleName)}>
        <img src='src/img/common/logo.png' />
        <h1>Qinetic</h1>
    </div>


