using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace iMakar_CTYoung_Client
{
    public partial class MainForm : Form
    {
        Properties.Settings setting = Properties.Settings.Default;
        public MainForm()
        {
            InitializeComponent();
        }

        private void btnlogin_Click(object sender, EventArgs e)
        {
            Properties.Settings.Default.passwd= txtPasswd.Text;
            Properties.Settings.Default.username = txtUsername.Text;
            CTYoung ct=CTYoung.Init(Properties.Settings.Default.location,cbIP.Text,txtUsername.Text, txtPasswd.Text);
            ct.Login();
        }

        private void lblSetting_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            using (Form setting = new Setting())
            {
                setting.Visible = false;
                this.Hide();
                setting.Owner = this; 

                setting.ShowDialog();
                this.Show();
            }

        }



        private void MainForm_Load(object sender, EventArgs e)
        {
            if (setting.isLogin)
            {
                txtPasswd.Enabled = false;
                txtUsername.Enabled = false;
                cbIP.Text = setting.ip;
                cbIP.Enabled = false;
                txtPasswd.Text = Properties.Settings.Default.passwd;
                txtUsername.Text = Properties.Settings.Default.username;
                btnlogin.Enabled=false;
            }
            else
            {
                var localhost = Dns.GetHostByName(Dns.GetHostName());
                foreach (var ip in localhost.AddressList)
                {
                    cbIP.Items.Add(ip.ToString());
                }
                txtPasswd.Text = Properties.Settings.Default.passwd;
                txtUsername.Text = Properties.Settings.Default.username;
                btnLogout.Enabled = false;
                
            }
            
        }
    }
}
