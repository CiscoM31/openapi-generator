/**
 * OpenAPI Petstore
 * This is a sample server Petstore server. For this sample, you can use the api key `special-key` to test the authorization filters.
 *
 * The version of the OpenAPI document: 1.0.0
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

/**
 * Based on http://www.creativepulse.gr/en/blog/2014/restful-api-requests-using-qt-cpp-for-linux-mac-osx-ms-windows
 * By Alex Stylianos
 *
 **/

#ifndef PFX_HTTPREQUESTWORKER_H
#define PFX_HTTPREQUESTWORKER_H

#include <QMap>
#include <QNetworkAccessManager>
#include <QNetworkReply>
#include <QObject>
#include <QString>

#include "PFXHttpFileElement.h"

namespace test_namespace {

enum PFXHttpRequestVarLayout {
    NOT_SET,
    ADDRESS,
    URL_ENCODED,
    MULTIPART
};

class PFXHttpRequestInput {

public:
    QString url_str;
    QString http_method;
    PFXHttpRequestVarLayout var_layout;
    QMap<QString, QString> vars;
    QMap<QString, QString> headers;
    QList<PFXHttpFileElement> files;
    QByteArray request_body;

    PFXHttpRequestInput();
    PFXHttpRequestInput(QString v_url_str, QString v_http_method);
    void initialize();
    void add_var(QString key, QString value);
    void add_file(QString variable_name, QString local_filename, QString request_filename, QString mime_type);
};

class PFXHttpRequestWorker : public QObject {
    Q_OBJECT

public:
    QByteArray response;
    QNetworkReply::NetworkError error_type;
    QString error_str;
    explicit PFXHttpRequestWorker(QObject *parent = nullptr);
    virtual ~PFXHttpRequestWorker();

    QMap<QString, QString> getResponseHeaders() const;
    QString http_attribute_encode(QString attribute_name, QString input);
    void execute(PFXHttpRequestInput *input);
    static QSslConfiguration *sslDefaultConfiguration;
    void setTimeOut(int tout);
    void setWorkingDirectory(const QString &path);
    PFXHttpFileElement getHttpFileElement(const QString &fieldname = QString());
    QByteArray *getMultiPartField(const QString &fieldname = QString());
    void setCompressionEnabled(bool enable);
signals:
    void on_execution_finished(PFXHttpRequestWorker *worker);

private:
    QNetworkAccessManager *manager;
    QMap<QString, QString> headers;
    QMap<QString, PFXHttpFileElement> files;
    QMap<QString, QByteArray *> multiPartFields;
    QString workingDirectory;
    int _timeOut;
    bool isCompressionEnabled;
    void on_manager_timeout(QNetworkReply *reply);
    void process_response(QNetworkReply *reply);
    QByteArray decompress(const QByteArray& data);
private slots:
    void on_manager_finished(QNetworkReply *reply);
};

} // namespace test_namespace

#endif // PFX_HTTPREQUESTWORKER_H
