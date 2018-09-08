import React, {Component} from 'react'
import cx from "classnames";
import styles from './list-panel.sass'
import {connect} from "react-redux";


const ListPanelPre = ({user}) =>
    <div>
        <h2>user's list</h2>
        <hr />
            <ul>
                {user.lists.map( (list, i) =>
                    <li key={i}>
                        {~`${user.lists.listName}`}
                        <img src='src/img/common/expendIcon.png'/>
                        <hr />
                    </li>
                    )
                }
            </ul>
    </div>

export const ListPanel = connect (
    state =>
        ({
            user: state.user
        }),
    null
)(ListPanelPre)
