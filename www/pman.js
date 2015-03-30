module.exports = {
    uninstall: function (packageName, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "PMan", "uninstall", [{
            "packageName": packageName
        }]);
    }
};
