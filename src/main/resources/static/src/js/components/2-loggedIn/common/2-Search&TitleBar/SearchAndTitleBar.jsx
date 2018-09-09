import React, {Component} from 'react'
import cx from "classnames";
import styles from './search-and-title-bar.sass'


const SearchAndTitleBar = ({styleName}) =>
    <div className={cx(styles['search-and-title-bar'], styleName)} >
        <h2>Search And Title Bar</h2>
        <hr />
    </div>

export default SearchAndTitleBar