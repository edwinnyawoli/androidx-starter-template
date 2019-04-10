# AndroidX Starter Template
A template that can help you quickly start building your android applications.

The structuring of this project is based on what is described
[here](https://overflow.buffer.com/2016/09/26/android-rethinking-package-structure/)
with a few modifications.

## What to do
There are a few things you would need to rename before you get started.
* `TemplateApplication` file
* `applicationId` in module *build.gradle* file
* `package` in *AndroidManifext.xml* file
* `app_name` in *strings.xml* file

This project uses **Crashlytics** for crash reporting. As a result, you need to provide a
*Fabric* api key. To provide your api key, create a **build.properties** file in the app
directory. Inside this file add your api key as a value to the property `FABRIC_API_KEY`.
It will look something like this

    FABRIC_API_KEY=my_random_api_key
