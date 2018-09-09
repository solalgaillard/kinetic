var path = require('path');

module.exports = {
    mode: 'development',
    entry: './src/js/main.js',
    output: {
        filename: 'bundle.js',
        path: path.resolve(__dirname, 'dist')
    },
    module: {
        rules: [
            {
                test: /\.sass$/,
                use: [
                    {
                        loader: 'style-loader',
                    },

                    {
                        loader: 'css-loader',
                        options: {
                            sourceMap: true,
                            modules: true,
                            localIdentName: '[local]___[hash:base64:5]'
                        }
                    },
                    {
                        loader: "sass-loader" // compiles Sass to CSS
                    }
                ],
            },
            { test: /\.(png|woff|woff2|eot|ttf|svg)$/, loader: 'url-loader?limit=100000' },
            { test: /\.(js|jsx)$/, exclude: /node_modules/, loader: "babel-loader" }
        ]
    }
};