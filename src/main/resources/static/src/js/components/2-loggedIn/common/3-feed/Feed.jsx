import { connect } from "react-redux"
import {loadFeed} from '../../../../reduxStore/actions'
import React, {Component} from 'react'
import cx from "classnames";
import styles from './feed.sass'



export class FeedPre extends Component {

    constructor(props) {
        super(props)
        const {loadFeedItems} = this.props
        loadFeedItems()
    }

    render() {

        const {feed, styleName} = this.props
        return (
            <div className={cx(styles.feed, styleName)}>
                <textarea>Post To Feed</textarea>
                <main>
                    {feed.map( (post, i) =>
                        <div key={i}>
                            <img src={post.userPicture}/>
                            <h1>{post.userName}</h1>
                            <p>
                                {post.message.map( (message, z) =>
                                    message.map ( (partMessage, z) =>
                                    (typeof partMessage === 'object') ?
                                            <span className={Object.keys(partMessage)[0]}
                                                  key={z}>{partMessage[Object.keys(partMessage)[0]]}</span>
                                            :
                                            partMessage
                                    )
                                )}
                            </p>


                        </div>
                    )}
                </main>
            </div>

        )
    }
}



export const Feed = connect (
    state =>
        ({
            feed: state.feed
        }),
    dispatch => ({
        loadFeedItems() {
            dispatch(loadFeed())
        }
        })
)(FeedPre)
