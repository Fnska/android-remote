# Android Remote Application for MPC-HC

Adapted solution for MPC-HC web interface. For those people who want to manage a video player over the Internet but are behind NAT and do not have Wi-Fi.

## Using

- AndroidSDK
- Vue.js
- MPC-HC

## Build

1. Download or rebuild **app-release.apk** file 
2. Add **index.html** to `path/to/MPC-HC/webroot/`
3. Download **.exe** file of [Ngrok](https://ngrok.com/) or use CLI
4. Set the launch parameters: http -auth="\<login\>:\<password\>" 13579


