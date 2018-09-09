import React, {Component} from 'react'
import cx from "classnames";
import styles from './other-users-panel.sass'
import {connect} from "react-redux";


const OtherUsersPanelPre = ({user, styleName}) =>
    <div className={cx(styles['other-users-panel'], styleName)} >
        <h3>following</h3>
        <hr />
        <ul>
            {user.following.map( (list, i) =>
                <li key={i}>
                    {`~${list.userName}`}
                </li>
            )
            }
        </ul>
        <hr />
        <h3>followers</h3>
        <hr />
        <ul>
            {user.followers.map( (list, i) =>
                <li key={i}>
                    {`~${list.userName}`}
                </li>
            )
            }
        </ul>
        <hr />
        <h3>blocked users</h3>
        <hr />
        <ul>
            {user.blocked.map( (list, i) =>
                <li key={i}>
                    {`~${list.userName}`}
                </li>
            )
            }
        </ul>
        <hr />
    </div>

export const OtherUsersPanel = connect (
    state =>
        ({
            user: state.user
        }),
    null
)(OtherUsersPanelPre)

