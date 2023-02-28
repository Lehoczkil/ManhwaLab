
module.exports = {
    devServer: {
      proxy: {
        '/': {
          target: 'http://ec2-3-75-0-59.eu-central-1.compute.amazonaws.com:8080',
          ws: false,
          changeOrigin: true,
        },
      }
    }
  }