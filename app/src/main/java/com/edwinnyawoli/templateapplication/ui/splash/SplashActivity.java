/*
 * Copyright 2019 Edwin Nyawoli
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.edwinnyawoli.templateapplication.ui.splash;

import android.os.Bundle;

import com.edwinnyawoli.templateapplication.ui.EmptyActivity;

import androidx.appcompat.app.AppCompatActivity;

import java.util.UUID;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(EmptyActivity.intentFor(this, UUID.randomUUID().toString()));
    }
}
