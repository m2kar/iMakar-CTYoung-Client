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

//TODO 引入事件和委托处理机制,多线程运行 有时间再弄
namespace iMakar_CTYoung_Client
{
    public partial class MainForm : Form
    {
        Properties.Settings setting = Properties.Settings.Default;
        CTYoung ct;
        public MainForm()
        {
            InitializeComponent();
            cbIP.Validating += CbIP_Validating;
        }

        private void CbIP_Validating(object sender, CancelEventArgs e)
        {
            CheckIP();
            //throw new NotImplementedException();
        }

        private void LoadStatusIsLogin()
        {
            txtPasswd.Enabled = false;
            txtUsername.Enabled = false;
            cbIP.Text = setting.ip;
            cbIP.Enabled = false;
            txtPasswd.Text = setting.passwd;
            txtUsername.Text = setting.username;
            btnlogin.Enabled = false;
            btnLogout.Enabled = true;
        }

        private void LoadStatusNotLogin()
        {
            txtPasswd.Text = setting.passwd;
            txtUsername.Text = setting.username;
            cbIP.Enabled = true;
            txtUsername.Enabled = true;
            txtPasswd.Enabled = true;
            btnlogin.Enabled = true;
            btnLogout.Enabled = false;
        }

        private void btnlogin_Click(object sender, EventArgs e)
        {
            CheckIP();
            ct = CTYoung.Init(Properties.Settings.Default.location, cbIP.Text, txtUsername.Text, txtPasswd.Text);
            if (ct.Login())
            {
                setting.passwd = txtPasswd.Text;
                setting.username = txtUsername.Text;
                setting.isLogin = true;
                setting.uuid = ct.Uuid;
                setting.ip = ct.Ip;
                MessageBox.Show("登陆成功");
                LoadStatusIsLogin();
            }
            else
            {
                MessageBox.Show("登陆失败");
            }
        }
        private void btnLogout_Click(object sender, EventArgs e)
        {
            if (ct.Logout())
            {
                MessageBox.Show("注销成功");
                setting.isLogin = false;
                setting.uuid = "";
                LoadStatusNotLogin();
            }
            else
            {
                var force=MessageBox.Show("注销失败,是否强制注销","",MessageBoxButtons.YesNo,MessageBoxIcon.Error);
                if (force==DialogResult.Yes)
                {
                    if (DialogResult.OK == MessageBox.Show("强制注销会造成你的账号短期内无法登陆\n是否继续?", "", MessageBoxButtons.OKCancel, MessageBoxIcon.Question))
                    {
                        setting.isLogin = false;
                        setting.uuid = "";
                        LoadStatusNotLogin();
                    }

                }
            }
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
                LoadStatusIsLogin();
                ct = CTYoung.Init(setting.location, setting.ip, setting.username, setting.passwd,setting.uuid);
            }
            else
            {
                LoadStatusNotLogin();
                var localhost = Dns.GetHostByName(Dns.GetHostName());
                foreach (var ip in localhost.AddressList)
                {
                    cbIP.Items.Add(ip.ToString());
                }
                cbIP.Text = "0.0.0.0";

            }

        }

        private void CheckIP()
        {
            if (!CTYoung.Is_ip_valid(cbIP.Text))
            {
                MessageBox.Show("Ip 格式错误", "", MessageBoxButtons.OK, MessageBoxIcon.Error);
                cbIP.Focus();
            }
        }

        private void cbIP_SelectedIndexChanged(object sender, EventArgs e)
        {
            //CheckIP();
        }
    }
}
