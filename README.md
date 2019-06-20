# AndroidX Starter Template
[![CircleCI](https://circleci.com/gh/edwinnyawoli/androidx-starter-template.svg?style=svg)](https://circleci.com/gh/edwinnyawoli/androidx-starter-template)

A template that can help you quickly start building your android applications.

The structuring of this project is based on what is described
[here](https://overflow.buffer.com/2016/09/26/android-rethinking-package-structure/)
with a few modifications.

## What to do
There are a few things you need to do to get started.
* Reinitialize git
    * Delete the .git folder
    * Start a git repo with `git init`
    * Make initial git commit with all files
* Rename or change value of
    * `TemplateApplication` file
    * `app_name` in *res/strings.xml* file
    * `applicationId` in *app/build.gradle* file
    * `package` in *AndroidManifest.xml* file
    * `working_directory` in *.circleci/config.yml* file

### Crashlytics

This template uses **Crashlytics** for crash reporting. As a result,
you need to provide a *Fabric* api key. To provide your api key, create
a **build.properties** file in the app directory. Inside this file
add your api key as a value to the property `FABRIC_API_KEY`.
It will look something like this

    FABRIC_API_KEY=my_random_api_key

You would also need to provide that api key to any CI server you use.
This template also has configuration for **CircleCI** included. To build
on CircleCI, add the fabric key as an environment variable with the name
`FABRIC_API_KEY`.

If you prefer not to use fabric you can remove the `meta-data` tag for
fabric in the Application Manifest and you should be able to
successfully build.