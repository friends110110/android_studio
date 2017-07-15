package com.umeng.example.analytics;

/**
 * Created by Administrator on 2017/7/15.
 */

public class StorageTest {
    /**
     * 未操作的时候
     * {"body":{"activate_msg":{"ts":1500097548650}},"header":{"failed_requests":0,"appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1184*720","version_code":1,"device_model":"HUAWEI C199","timezone":8,"device_name":"hwC199","mc":"24:09:95:eb:67:78","req_time":0,"carrier":"中国电信","successful_requests":0,"device_board":"C199","vertical_type":0,"device_manufacturer":"HUAWEI","id_tracking":"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWltvQzKhXFQIAA21hYxgRMjQ6MDk6OTU6\nZWI6Njc6NzgWjNvQzKhXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4Fpza0MyoVxUCAARpbWVpGA5B\nMDAwMDA0RkYyNEQxOBaA29DMqFcVAgAFaWRtZDUYIGNlOWNkZTcyOTg3ZjM5YjZjYzg1Mzc3OWQ5\nNWUxZTdkFtja0MyoVxUCABlcGAZzZXJpYWwoDDI0MDk5NWViNzcxOBac2tDMqFcAGAVpZG1kNSgg\nY2U5Y2RlNzI5ODdmMzliNmNjODUzNzc5ZDk1ZTFlN2QW2NrQzKhXABgEaW1laSgOQTAwMDAwNEZG\nMjREMTgWgNvQzKhXABgDbWFjKBEyNDowOTo5NTplYjo2Nzo3OBaM29DMqFcAGAphbmRyb2lkX2lk\nKBA0MTFjZjZiYjBiZmY2YThmFpbb0MyoVwAA\n","os":"Android","app_signature":"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A","cpu":"ARMv7 Processor rev 3 (v7l)","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"A000004FF24D18","device_brand":"Huawei","access":"wifi","country":"CN","os_version":"4.4.2","idmd5":"ce9cde72987f39b6cc853779d95e1e7d","display_name":"友盟SDK","sdk_type":"Android","device_manuid":"HuaweiC199","mccmnc":"46003","language":"zh","channel":"Umeng","device_manutime":1422528853000}}
     */

    /**
     * 点击一次 open_new_page页面的时候
     * {"body":{"sessions":[{"id":"E559C567A13B5D1E4A90634C8DC73CB7","end_time":"1500097547767","start_time":"1500097547556","duration":211}]},"header":{"failed_requests":0,"appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1184*720","version_code":1,"device_model":"HUAWEI C199","timezone":8,"device_name":"hwC199","mc":"24:09:95:eb:67:78","imprint":"GwqMB3ByZXRpbWUYDTE1MDAwOTc3MTQ3NDMW7ujUzKhXGCg0N2Y4YTY3NDExYzYwZWRiNjdjM2Vj\nODlmYmFhZWI4NDNiZmU0YzY0ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW7ujUzKhXGCg0N2Y4\nYTY3NGFlODE3YmQ0MmIwN2RiNWZhMzA3NTRhMWY0MWY4NWFiAA9pbnN0YWxsX2NoYW5uZWwYBVVt\nZW5nFu7o1MyoVxgoNDdmOGE2NzQ4YjgyNmQ1N2M0ZGM0MGIxZTMwN2QzMmE1Zjc0ODFhNQALYXBw\nX3ZlcnNpb24YAzEuMBbu6NTMqFcYKDQ3ZjhhNjc0ZTQwOGRjY2RlMjFlMDNjZWJiMjc1MTJjMjE0\nNTJjMzgAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTI6NTc6NDUW7ujUzKhXGCg0N2Y4\nYTY3NGQwZGZmNzlhMDM4NWJhYTlmYmYzMTZlNjk5MzNiNTEwAApvc192ZXJzaW9uGAU0LjQuMhbu\n6NTMqFcYKDQ3ZjhhNjc0NzBlZDVlZWI5ZWY3OTVjYzRjZGZhMGU4ZDM3ZGMyYTIAAXYYBTUtNS01\nFu7o1MyoVxgoNDdmOGE2NzRlZWY0MzY5YWY5MGFkNjYxNjYwMTU4Yzk2Yzk5Y2NmOQAGaml0dGVy\nGAEwFu7o1MyoVxgoNDdmOGE2NzQwNmQyNDRmYTk0NzdlMWRkN2IwMWM0MjAzY2E1MzgzMgAHY2hh\nbm5lbBgFVW1lbmcW7ujUzKhXGCg0N2Y4YTY3NDY2MGY4OGJiNzRmZmU1NjA3ODAwODJiMDY4M2Q5\nNGNhAAR1bWlkGCBjZTljZGU3Mjk4N2YzOWI2Y2M4NTM3NzlkOTVlMWU3ZBbu6NTMqFcYKDQ3Zjhh\nNjc0MTlkNTEwMjg2ODIwZjA1NjNjMTY2OTg3ODFjNDQyYWUAFQIYIDU5ZWNlZDdlMDQ1OTVmNTli\nNTY3Yzc2NjU3ZjI0MjJlAA==\n","req_time":720,"carrier":"中国电信","successful_requests":1,"device_board":"C199","vertical_type":0,"device_manufacturer":"HUAWEI","id_tracking":"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWltvQzKhXFQIAA21hYxgRMjQ6MDk6OTU6\nZWI6Njc6NzgWjNvQzKhXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4Fpza0MyoVxUCAARpbWVpGA5B\nMDAwMDA0RkYyNEQxOBaA29DMqFcVAgAFaWRtZDUYIGNlOWNkZTcyOTg3ZjM5YjZjYzg1Mzc3OWQ5\nNWUxZTdkFtja0MyoVxUCAAA=\n","os":"Android","app_signature":"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A","cpu":"ARMv7 Processor rev 3 (v7l)","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"A000004FF24D18","device_brand":"Huawei","access":"wifi","country":"CN","os_version":"4.4.2","idmd5":"ce9cde72987f39b6cc853779d95e1e7d","display_name":"友盟SDK","sdk_type":"Android","device_manuid":"HuaweiC199","mccmnc":"46003","language":"zh","channel":"Umeng","device_manutime":1422528853000}}
     */

    /**
     * 点击n次 MY_EVENT_ID事件的数据
     * {"body":{"ekv":[{"6C7F57FBEE49702C870E91415107AF82":[{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097966553,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097966585,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097966593,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097967753,"MY_EVENT_ID":""},{"id":"MY_EVENT_ID","_umpname":"com.umeng.example.analytics.AnalyticsHome","ts":1500097968188,"MY_EVENT_ID":""}]}],"sessions":[{"id":"6C7F57FBEE49702C870E91415107AF82","end_time":"1500097847996","start_time":"1500097847869","duration":127}]},"header":{"failed_requests":0,"appkey":"596087883eae2574b10013a3","app_version":"1.0","resolution":"1184*720","version_code":1,"device_model":"HUAWEI C199","timezone":8,"device_name":"hwC199","mc":"24:09:95:eb:67:78","imprint":"GwqMB3ByZXRpbWUYDTE1MDAwOTc5NjAzNzQW7ObyzKhXGChjNjNiYTI3NDQ2ZjBhMmU5OGQ1YmNm\nNzIzMjJjMGFjMWIwNjE4MmU4ABNpbnN0YWxsX2FwcF92ZXJzaW9uGAMxLjAW7ujUzKhXGCg0N2Y4\nYTY3NGFlODE3YmQ0MmIwN2RiNWZhMzA3NTRhMWY0MWY4NWFiAA9pbnN0YWxsX2NoYW5uZWwYBVVt\nZW5nFu7o1MyoVxgoNDdmOGE2NzQ4YjgyNmQ1N2M0ZGM0MGIxZTMwN2QzMmE1Zjc0ODFhNQALYXBw\nX3ZlcnNpb24YAzEuMBbu6NTMqFcYKDQ3ZjhhNjc0ZTQwOGRjY2RlMjFlMDNjZWJiMjc1MTJjMjE0\nNTJjMzgAEGluc3RhbGxfZGF0ZXRpbWUYEzIwMTctMDctMDkgMTI6NTc6NDUW7ujUzKhXGCg0N2Y4\nYTY3NGQwZGZmNzlhMDM4NWJhYTlmYmYzMTZlNjk5MzNiNTEwAApvc192ZXJzaW9uGAU0LjQuMhbu\n6NTMqFcYKDQ3ZjhhNjc0NzBlZDVlZWI5ZWY3OTVjYzRjZGZhMGU4ZDM3ZGMyYTIAAXYYBTUtNS01\nFu7o1MyoVxgoNDdmOGE2NzRlZWY0MzY5YWY5MGFkNjYxNjYwMTU4Yzk2Yzk5Y2NmOQAGaml0dGVy\nGAEwFu7o1MyoVxgoNDdmOGE2NzQwNmQyNDRmYTk0NzdlMWRkN2IwMWM0MjAzY2E1MzgzMgAHY2hh\nbm5lbBgFVW1lbmcW7ujUzKhXGCg0N2Y4YTY3NDY2MGY4OGJiNzRmZmU1NjA3ODAwODJiMDY4M2Q5\nNGNhAAR1bWlkGCBjZTljZGU3Mjk4N2YzOWI2Y2M4NTM3NzlkOTVlMWU3ZBbu6NTMqFcYKDQ3Zjhh\nNjc0MTlkNTEwMjg2ODIwZjA1NjNjMTY2OTg3ODFjNDQyYWUAFQIYIGZiNTdkNzU4ZWRlZWIyODlk\nYmZkOTdjYTI1ZGFkM2MxAA==\n","req_time":84,"carrier":"中国电信","successful_requests":2,"device_board":"C199","vertical_type":0,"device_manufacturer":"HUAWEI","id_tracking":"GwWMCmFuZHJvaWRfaWQYEDQxMWNmNmJiMGJmZjZhOGYWltvQzKhXFQIAA21hYxgRMjQ6MDk6OTU6\nZWI6Njc6NzgWjNvQzKhXFQIABnNlcmlhbBgMMjQwOTk1ZWI3NzE4Fpza0MyoVxUCAARpbWVpGA5B\nMDAwMDA0RkYyNEQxOBaA29DMqFcVAgAFaWRtZDUYIGNlOWNkZTcyOTg3ZjM5YjZjYzg1Mzc3OWQ5\nNWUxZTdkFtja0MyoVxUCAAA=\n","os":"Android","app_signature":"A8:85:FE:29:16:07:F8:12:EE:78:15:A2:0F:F3:49:6A","cpu":"ARMv7 Processor rev 3 (v7l)","package_name":"com.umeng.example","sdk_version":"6.1.1","device_id":"A000004FF24D18","device_brand":"Huawei","access":"wifi","country":"CN","os_version":"4.4.2","idmd5":"ce9cde72987f39b6cc853779d95e1e7d","display_name":"友盟SDK","sdk_type":"Android","device_manuid":"HuaweiC199","mccmnc":"46003","language":"zh","channel":"Umeng","device_manutime":1422528853000}}
     */
}