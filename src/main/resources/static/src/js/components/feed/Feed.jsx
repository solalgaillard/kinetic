import React, {Component} from 'react'
import cx from "classnames";
import styles from './feed.sass'



export class Feed extends Component {

    constructor(props) {
        super(props)
    }

    componentWillMount() {
        const {stuff} = this.props
        stuff()

}

    render() {

        const {homeFeed} = this.props
        return (
            <div className={styles.feed}>
                <main>
                    {homeFeed.map( (post, i) =>
                        <div key={i}>
                        <img src={post.userPicture}/>
                        <h1>{post.userName}</h1>
                        <p>
                            {post.message.map( (description, z) => <span key={z}>{description.text}</span>)}
                        </p>


                        </div>
                    )}
                </main>
            </div>

        )}
}

