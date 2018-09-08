import { connect } from "react-redux"
import React, {Component} from 'react'
import cx from "classnames";
import styles from './profile.sass'


const ProfilePre = ({ user }) =>
    <div>
        <img src={user.userPicture} />
        <h1>{user.userName}</h1>
        <img src='src/img/common/expendIcon.png' />
    </div>


export const Profile = connect (
    state =>
        ({
            user: state.user
        }),
    null
)(ProfilePre)
