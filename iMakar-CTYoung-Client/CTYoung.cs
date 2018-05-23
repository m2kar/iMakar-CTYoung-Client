using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace iMakar_CTYoung_Client
{
    class CTYoung
    {
        string id;
        string passwd;
        string ip;
        CTYoung(string ip, string id, string passwd)
        {
            this.ip = ip;
            this.id = id;
            this.passwd = passwd;
        }
        static bool is_ip_valid(string ip)
        {
            //TODO complete this  
            return true;
        }
        static string encrypt_passwd(string passwd)
        {
            //TODO encrypt passwd
            return "";
        }
        void login()
        {
            //TODO
        }
        void logout()
        {
            //TODO
        }

    }
}
